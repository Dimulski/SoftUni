function addItem() {
    let itemText = document.getElementById('newItemText').value;
    let itemValue = document.getElementById('newItemValue').value;
    let newOption = document.createElement('option');
    newOption.textContent = itemText;
    newOption.value = itemValue;
    let menu = document.getElementById('menu');
    menu.appendChild(newOption);
    document.getElementById('newItemText').value = '';
    document.getElementById('newItemValue').value = '';
}