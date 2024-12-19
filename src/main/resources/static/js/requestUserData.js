async function requestUserData(token, sub)
{
    try
    {
        const response = await fetch(`/login/getUserData?login=${sub}`,
        {
            method: 'GET',
            headers:
            {
                'Authorization': `Bearer ${token}`,
                'Content-Type': 'application/json',
            },
        });

        if (!response.ok)
        {
            throw new Error('Ошибка при получении данных пользователя');
        }

        const userData = await response.json();

        outputData(userData);
    }
    catch (error)
    {
        console.error('Ошибка:', error);
        return null;
    }
}

function parseJwt(token)
{
    var base64Url = token.split('.')[1];

    var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');

    var payload = decodeURIComponent(window.atob(base64).split('').map(function(c)
    {
        return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
    }).join(''));

    return JSON.parse(payload);
}

function outputData(userData)
{
    const accountInfoDiv = document.getElementById("accInfo");

    accountInfoDiv.innerHTML = `
                <p>Логин: ${userData.login}</p>
                <p>Адрес электронной почты: ${userData.email}</p>
                <p>Номер телефона: ${userData.phoneNumber}</p>
                <p>Имя: ${userData.firstName}</p>
                <p>Фамилия: ${userData.lastName}</p>
                <p>Название организации: ${userData.company}</p>
    `;
}

const token = localStorage.getItem('token');

if(token !== null)
{
    const parsedToken = parseJwt(token);

    requestUserData(token, parsedToken.sub);
}
else
{
    window.location.href = "/login";
}