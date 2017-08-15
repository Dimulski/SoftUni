$(function () {
    $('#btnLoad').click(loadContacts);
    let createBtn = $('#btnCreate');
    createBtn.click(createContact);
    let baseServiceUrl = "https://phonebook-93f3a.firebaseio.com/phonebook";

    function loadContacts() {
        $('#phonebook').empty();
        $.get(baseServiceUrl + '.json')
            .then(displayContacts)
            .catch(displayError);
    }

    function displayContacts(contacts) {
        for (let key in contacts) {
            let person = contacts[key]['person'];
            let phone = contacts[key]['phone'];
            let li = $('<li>');
            li.text(person + ': ' + phone + ' ');
            $('#phonebook').append(li);
            li.append($('<button>Delete</button>').click(deleteContact.bind(this, key)));
        }
    }

    function displayError(err) {
        notify("Error: " + err.statusText, "error");
    }

    function createContact() {
        let name = $('#person').val();
        let phone = $('#phone').val();
        if (name.length === 0) {
            notify("Name cannot be empty", "error");
            return;
        }
        if (phone.length === 0) {
            notify("Phone cannot be empty", "error");
            return;
        }
        createBtn.prop('disabled', true);
        let newContactJSON = JSON.stringify({
            person: name,
            phone: phone
        });
        $.post(baseServiceUrl + '.json', newContactJSON)
            .then(() => { notify("Created", "success"); loadContacts() })
            .catch(displayError)
            .done(() => $('#btnCreate').prop('disabled', false));
        $('#person').val('');
        $('#phone').val('');
    }

    function deleteContact(key) {
        let request = {
            method: 'DELETE',
            url: baseServiceUrl + '/' + key + '.json',
            success: () => {
                notify("Deleted", "info");
                loadContacts();
            }
        };
        $.ajax(request)
            .catch(displayError);
    }

    function notify(message, type) {
        let toast = document.getElementById("notification");
        toast.textContent = message;
        toast.style.display = "block";
        switch (type) {
            case "error": toast.style.background = '#991111'; break;
            case "info": toast.style.background = '#111199'; break;
            case "success": toast.style.background = '#119911'; break;
        }

        setTimeout(() => toast.style.display = "none", 2000);
    }
});