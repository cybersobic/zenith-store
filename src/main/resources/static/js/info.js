async function requestProductById(productId) {
    try {
        const response = await fetch(`/info/${productId}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            },
        });

        if (!response.ok) {
            throw new Error('Ошибка при получении данных о товарах');
        }

        const product = await response.json();

        const productInfo = document.getElementById('product_info');

        productInfo.innerHTML = `
            <div class="back_to_catalog">
                <a class="btn btn-primary" href="/catalog">Вернуться в каталог</a>
            </div>
            <div class="info_content">
                <div>
                    <img class="product_image" src="${product.imageLink}" width=200px>
                </div>
                <div>
                    <h3 class="product_name">${product.name}</h3></br></br>
                    <p class="product_price">${product.price} руб.</p></br></br>
                    <p class="product_description">${product.description}</p></br></br>
                    <a class="buy_product" href="#">Купить</a>
                </div>
            </div>
        `;
    }
    catch (error) {
        console.error('Ошибка:', error);
    }
}

const urlParams = new URLSearchParams(window.location.search);

const productId = urlParams.get('productId');

if (productId) {
    requestProductById(productId);
}