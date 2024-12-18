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

const token = localStorage.getItem('token');

if(token !== null)
{
    const parsedToken = parseJwt(token);
    requestUserData(token, parsedToken.sub);
}
else
{
    alert("no login now");
}



