function generateReceipt() {
    const settings = {
        "async": true,
        "crossDomain": true,
        "url": "http://localhost:8080/api/receipt/generate",
        "method": "GET",
        "headers": {
          "User-Agent": "insomnia/12.0.0"
        }
      };
      
    $.ajax(settings).done(function (response) {
        console.log(response);
    });
    
}