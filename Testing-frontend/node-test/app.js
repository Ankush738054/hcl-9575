export const greet = (name) =>{
    return `Hello, ${name}!`;
}

export const greetInHindi = (name) => {
    return `Namaste, ${name}!`;
}

export const processOrder = (data, dependency) =>{
    // apply logic 
    // call payment gateway
    return dependency.processPayment(data.amount);
};

const processPayment = (amount) =>{
    //API Call to external payment gateway
    console.log('i am origianl processPayment');
    return { id: "123", amount};
}