// Function to get the current cart from local storage, or initialize an empty array
function getCart() {
    const cartJson = localStorage.getItem('shoppingCart');
    return cartJson ? JSON.parse(cartJson) : [];
}

// Function to save the cart to local storage
function saveCart(cart) {
    localStorage.setItem('shoppingCart', JSON.stringify(cart));
}

// Logic to add a product to the cart
function addToCart(id, name, price) {
    const cart = getCart();
    const existingItem = cart.find(item => item.id === id);

    if (existingItem) {
        existingItem.quantity += 1;
        existingItem.totalPrice = existingItem.quantity * existingItem.price;
    } else {
        cart.push({ id, name, price, quantity: 1, totalPrice: price });
    }

    saveCart(cart);
    alert(`${name} added to cart!`);
    displayCart(); // Update display if on the cart page
}

// Logic to display the cart content on the cart.html page
function displayCart() {
    const cart = getCart();
    const cartList = document.getElementById('cart-items');
    const cartTotalElement = document.getElementById('cart-total');

    if (!cartList || !cartTotalElement) return; // Exit if elements don't exist (e.g., if on menu.html)

    cartList.innerHTML = '';
    let grandTotal = 0;

    cart.forEach(item => {
        const listItem = document.createElement('li');
        listItem.innerHTML = `
            ${item.name} (x${item.quantity}) - $${item.totalPrice.toFixed(2)}
            <button onclick="changeQuantity(${item.id}, -1)">-</button>
            <button onclick="changeQuantity(${item.id}, 1)">+</button>
            <button onclick="removeItem(${item.id})">Remove</button>
        `;
        cartList.appendChild(listItem);
        grandTotal += item.totalPrice;
    });

    cartTotalElement.textContent = grandTotal.toFixed(2);
}

// Logic to change item quantity
function changeQuantity(id, change) {
    let cart = getCart();
    const itemIndex = cart.findIndex(item => item.id === id);

    if (itemIndex > -1) {
        const item = cart[itemIndex];
        item.quantity += change;

        if (item.quantity <= 0) {
            cart.splice(itemIndex, 1); // Remove if quantity is 0 or less
        } else {
            item.totalPrice = item.quantity * item.price;
        }

        saveCart(cart);
        displayCart();
    }
}

// Logic to remove an item completely
function removeItem(id) {
    let cart = getCart();
    cart = cart.filter(item => item.id !== id);
    saveCart(cart);
    displayCart();
}

// Logic to clear the entire cart
function clearCart() {
    if (confirm("Are you sure you want to empty the cart?")) {
        localStorage.removeItem('shoppingCart');
        displayCart();
    }
}

// pay cart
function payCart() {
    const options = {method: 'POST', headers: {'User-Agent': 'insomnia/12.0.0'}};

    fetch('http://localhost:8080/api/order/pay', options)
      .then(response => response.json())
      .then(response => console.log(response))
      .catch(err => console.error(err));
}