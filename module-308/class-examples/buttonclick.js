function changeText() {
    
    const p = document.querySelector('discordConfigPTag');      /* could be 'button' instead e.g. */
    p.textContent = "Changed because of an event handler property";

    const buttom = document.querySelector('button')
    button.textContent = "I was clicked";
}

function gotoLookup() {
    window.location.href; = '/lookup.html';
}
