var categoriesList = document.getElementsByClassName("category");

selectCategory(categoriesList[0]);
requestProducts(0);
var active = 0;

for (let i = 0; i < categoriesList.length; i++) {
    categoriesList[i].addEventListener("click", function() {
        if(i != active) {
            resetCategories();
            selectCategory(categoriesList[i]);
            requestProducts(i);

            active = i;
        }
    });
}

function selectCategory(category) {
    category.style.backgroundColor = "#546973";
    category.style.color = "white";
}

function resetCategories() {
    for (let i = 0; i < categoriesList.length; i++) {
        categoriesList[i].style.backgroundColor = "";
        categoriesList[i].style.color = "";
    }
}

async function requestProducts(i) {
    try {
        const response = await fetch(`/catalog/products?categoryId=${i}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            },
        });

        if (!response.ok) {
            throw new Error('Ошибка при получении данных о товарах');
        }

        const products = await response.json();

        const productContainer = document.getElementById("productListContainer");
        
        productContainer.innerHTML = '';

        products.forEach(product => {
            const productElement = document.createElement('div');
            
            productElement.classList.add('prods');
            
            productElement.innerHTML = `
                <div class="product_image">
                    <img src="${product.imageLink}" alt="product_default_image">
                </div>
                <div class="product_content">
                    <a href="/info?productId=${product.id}" class="product_name">${product.name}</a><br>
                    <p class="product_price">${product.price} руб.</p><br>
                </div>
                <div class="product_menu">
                    <a class="buy_product" href="#">Купить</a>
                </div>
            `;

            productContainer.appendChild(productElement);
        });
    }
    catch (error) {
        console.error('Ошибка:', error);
        return null;
    }
}

