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

/*ProfileF  BookingRequestF  BookingResponsesF  PaymentsF*/
/*ProfileForm  BookingRequestForm  BookingResponsesForm  PaymentsForm */
document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("ProfileF").style.display = 'inline-block';
    document.getElementById("BookingRequestF").style.display = 'none';
    document.getElementById("BookingResponsesF").style.display = 'none';
    document.getElementById("PaymentsF").style.display = 'none';

});
document.getElementById("ProfileForm").addEventListener('click', function () {
    document.getElementById("ProfileF").style.display = 'inline-block';
    document.getElementById("BookingRequestF").style.display = 'none';
    document.getElementById("BookingResponsesF").style.display = 'none';
    document.getElementById("PaymentsF").style.display = 'none';
});
document.getElementById("BookingRequestForm").addEventListener('click', function () {
    document.getElementById("ProfileF").style.display = 'none';
    document.getElementById("BookingRequestF").style.display = 'inline-block';
    document.getElementById("BookingResponsesF").style.display = 'none';
    document.getElementById("PaymentsF").style.display = 'none';
});
document.getElementById("BookingResponsesForm").addEventListener('click', function () {
    document.getElementById("ProfileF").style.display = 'none';
    document.getElementById("BookingRequestF").style.display = 'none';
    document.getElementById("BookingResponsesF").style.display = 'inline-block';
    document.getElementById("PaymentsF").style.display = 'none';
});
document.getElementById("PaymentsForm").addEventListener('click', function () {
    document.getElementById("ProfileF").style.display = 'none';
    document.getElementById("BookingRequestF").style.display = 'none';
    document.getElementById("BookingResponsesF").style.display = 'none';
    document.getElementById("PaymentsF").style.display = 'inline-block';
});