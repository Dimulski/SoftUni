function validate() {
    $('#company').on('change', showHideCompany);

    $('#submit').on('click', function (event) {
        event.preventDefault();
        let usernameRegex = /^[a-zA-Z0-9]{3,20}$/;
        let passwordRegex = /^\w{5,15}$/;
        let emailRegex = /@.*\./;
        let companyNumberRegex = /^[1-9]{1}[0-9]{3}$/;

        let allFieldsValid = true;

        let username = $('#username');
        let email = $('#email');
        let password = $('#password');
        let confirmPassword = $('#confirm-password');
        let companyCheckbox = $('#company');
        let companyNumber = $('#companyNumber');
        let valid = $('#valid');

        if (username.val().match(usernameRegex)) {
            username.css('border', 'none');
        } else {
            username.css('border-color', 'red');
            allFieldsValid = false;
        }

        if (email.val().match(emailRegex)) {
            email.css('border', 'none');
        } else {
            email.css('border-color', 'red');
            allFieldsValid = false;
        }

        if (password.val().match(passwordRegex) && password.val().localeCompare(confirmPassword.val()) === 0) {
            password.css('border', 'none');
        } else {
            password.css('border-color', 'red');
            allFieldsValid = false;
        }

        if (confirmPassword.val().match(passwordRegex) && confirmPassword.val().localeCompare(password.val()) === 0) {
            confirmPassword.css('border', 'none');
        } else {
            confirmPassword.css('border-color', 'red');
            allFieldsValid = false;
        }

        if (companyCheckbox.is(':checked')) {
            if (companyNumber.val().match(companyNumberRegex)) {
                companyNumber.css('border', 'none');
            } else {
                companyNumber.css('border-color', 'red');
                allFieldsValid = false;
            }
        }

        if (allFieldsValid) {
            valid.css('display', 'block');
        } else {
            valid.css('display', 'none');
        }
    });

    function showHideCompany() {
        if ($(this).is(':checked')) {
            $('#companyInfo').css('display', 'block');
        } else {
            $('#companyInfo').css('display', 'none');
        }
    }
}