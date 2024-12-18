function changeElements()
{
    const loginButton = document.getElementById("lgBut");
    loginButton.textContent = "✪ Мой профиль";
    loginButton.href = "/profile";
}

const token = localStorage.getItem('token');

if(token !== null)
{
    changeElements();
}



