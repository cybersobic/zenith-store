async function requestProductById(productId)
{
    try
    {
        const response = await fetch(`/info/${productId}`,
        {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            },
        });

        if (!response.ok)
        {
            throw new Error('Ошибка при получении данных о товарах');
        }

        const product = await response.json();

        const productInfo = document.getElementById('product_info');

        productInfo.innerHTML = `
            <img src="${product.imageLink}" width=200px>
            <h3>${product.name}</h3>
            <p>${product.price} руб.</p>
            <p>${product.description}</p>
        `;
    }
    catch (error)
    {
        console.error('Ошибка:', error);
    }
}

const urlParams = new URLSearchParams(window.location.search);

const productId = urlParams.get('productId');

if (productId)
{
    requestProductById(productId);
}