var loginButton = document.getElementById("loginButton");

async function checkDataToLogin(event)
{
    event.preventDefault();

    var login = document.getElementById("l_login").value;
    var password = document.getElementById("l_password").value;

    if (login !== "" && password !== "")
    {
        try
        {
            const response = await fetch('http://localhost:8080/auth/login',
            {
                method: 'POST',
                headers:
                {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ login, password }),
            });

            if (response.ok)
            {
                const data = await response.json();

                console.log('Ваш токен:', data.token);

                alert(data.token);

                localStorage.setItem('token', data.token);

                requestUserData(login);
            }
            else
            {
                alert("Неверный логин или пароль.");
            }
        }
        catch (error)
        {
            alert("Не удалось соединиться с сервером.");
        }
    }
    else 
    {
        alert("Заполните все поля корректно!");
    }
}

async function requestUserData(login)
{
    try
    {
        const response = await fetch(`/login/getUserData?login=${login}`,
        {
            method: 'GET',
            headers:
            {
                'Content-Type': 'application/json',
            },
        });

        if (!response.ok)
        {
            throw new Error('Ошибка при получении данных пользователя');
        }

        const userData = await response.json();

        alert(userData.login);
        alert(userData.email);
        alert(userData.phoneNumber);
        alert(userData.firstName);
        alert(userData.lastName);
        alert(userData.company);

    }
    catch (error)
    {
        console.error('Ошибка:', error);
        return null;
    }
}

loginButton.addEventListener("click", checkDataToLogin);
