var loginButton = document.getElementById("loginButton");

function checkDataToLogin(event) 
{
    event.preventDefault();

    var login = document.getElementById("l_login").value;
    var password = document.getElementById("l_password").value;

    if (login !== "" && password !== "")
    {
        fetch('/login', 
        {
            method: 'POST',
            headers: 
            {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ login: login, password: password })
        })
        .then(response => response.json())
        .then(data => 
        {
            if (data.loginStatus)
            {
                window.location.href = "/";
            } 
            else
            {
                alert("Неверные данные для входа!");
            }
        })
        .catch(error => console.error('Ошибка:', error));
    } 
    else 
    {
        alert("Заполните все поля корректно!");
    }
}

loginButton.addEventListener("click", checkDataToLogin);
