

document.querySelector(".pay").addEventListener("click", function () {
  console.log("function is working");
  const amount = document.querySelector("#payment").value;
  console.log(amount);
  if (amount == "" || amount == null) {
    alert("amount is required");
  }

  $.ajax({
    url: "/createOrder",
    data: JSON.stringify({ amount: amount, info: "orderRequest" }),
    contentType: "application/json",
    type: "POST",
    dataType: "json",
    success: function (response) {
      console.log(response);
      if (response.status == "created") {
        var options = {
          key: "rzp_test_6zgHqKyqNjr12S", // Enter the Key ID generated from the Dashboard
          amount: response.amount, // Amount is in currency subunits. Default currency isINR. Hence, 50000 refers to 50000 paise
          currency: "INR",
          name: "utkarshHardwareAndPlywoods",
          description: "Test Transaction",
          image:
            "https://i.pinimg.com/736x/01/70/ac/0170ac93defd54feb35a5fb74f087538.jpg",
          order_id: response.id, //This is a sample Order ID. Pass the`id` obtained in the response of Step 1
          handler: function (response) {
            console.log(response.razorpay_payment_id);
            console.log(response.razorpay_order_id);
            console.log(response.razorpay_signature);
            console.log("payment successful !!");
            alert("Payment successfull");
           // swal("Good job!", "congrates !! Payment successful !!", "success");
          },
          prefill: {
            name: "",
            email: "",
            contact: "",
          },
          notes: {
            address: "Mathura",
          },
          theme: {
            color: "#3399cc",
          },
        };

        let rzp = new Razorpay(options);

        rzp.on("payment.failed", function (response) {
          console.log(response.error.code);
          console.log(response.error.description);
          console.log(response.error.source);
          console.log(response.error.step);
          console.log(response.error.reason);
          console.log(response.error.metadata.order_id);
          console.log(response.error.metadata.payment_id);
          alert("Oops payment failed !!");
          //swal("Failed !!", "Oops payment failed !!", "error");
        });

        rzp.open();
      }
    },
    error: function (error) {
      console.log("Something Went Wrong");
      alert("error");
    },
  });
});
