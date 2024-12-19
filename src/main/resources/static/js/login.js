var loginButton = document.getElementById("loginButton");

async function checkDataToLogin(event) {
    event.preventDefault();

    var login = document.getElementById("l_login").value;
    var password = document.getElementById("l_password").value;

    if (login !== "" && password !== "") {
        try {
            const response = await fetch('http://localhost:8080/auth/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ login, password }),
            });

            if (response.ok) {
                const data = await response.json();

                localStorage.setItem('token', data.token);

                document.location.href = "/";
            }
            else {
                alert("Неверный логин или пароль.");
            }
        }
        catch (error) {
            alert("Не удалось соединиться с сервером.");
        }
    }
    else {
        alert("Заполните все поля корректно!");
    }
}

loginButton.addEventListener("click", checkDataToLogin);
