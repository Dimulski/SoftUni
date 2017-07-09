function create(params) {
    let content = document.getElementById('content');
    let p = undefined;
    let div = undefined;
    for (let i = 0; i < params.length; i++) {
        p = document.createElement('p');
        p.style.display = 'none';
        p.textContent = params[i];
        div = document.createElement('div');
        div.addEventListener('click', show);
        div.appendChild(p);
        content.appendChild(div);
    }

    function show(event) {
        event.target.childNodes[0].style.display = '';
    }
}