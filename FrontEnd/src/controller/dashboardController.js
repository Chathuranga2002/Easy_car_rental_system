// add hovered class to selected list item
let list = document.querySelectorAll(".navigation li");

function activeLink() {
  list.forEach((item) => {
    item.classList.remove("hovered");
  });
  this.classList.add("hovered");
}

list.forEach((item) => item.addEventListener("mouseover", activeLink));

// Menu Toggle
let toggle = document.querySelector(".toggle");
let navigation = document.querySelector(".navigation");
let main = document.querySelector(".main");

toggle.onclick = function () {
  navigation.classList.toggle("active");
  main.classList.toggle("active");
};

//=================================save rent=========================
// $('#sendRequest').click(function () {
//   let regNo = $('#cmbRegistrationNo').find('option:selected').text();
//   if (regNo != "" && regNo != "-Select Registration No-" && $('#txtCarPickupDate').val()!="" ) {
//     let custId = custUsename;
//
//     searchCustomerById(custUsename);
//   } else {
//     alert("Please fill rental fields"+custUsename);
//   }
// })
//
// const sendRequestButton = document.getElementById('sendRequest');
//
// sendRequestButton.addEventListener('click', function() {
//   // Your code to handle the click event goes here
// });
