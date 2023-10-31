
document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("DashboardF").style.display = 'inline-block';
    document.getElementById("CarF").style.display = 'none';
    document.getElementById("CustomerF").style.display = 'none';
    document.getElementById("DriverF").style.display = 'none';
    document.getElementById("CarRentalF").style.display = 'none';
    document.getElementById("PaymentF").style.display = 'none';
    document.getElementById("rentalRequest").style.display = 'none';
});

document.getElementById("DashboardForm").addEventListener('click', function () {
    document.getElementById("DashboardF").style.display = 'inline-block';
    document.getElementById("CarF").style.display = 'none';
    document.getElementById("CustomerF").style.display = 'none';
    document.getElementById("DriverF").style.display = 'none';
    document.getElementById("CarRentalF").style.display = 'none';
    document.getElementById("PaymentF").style.display = 'none';
    document.getElementById("rentalRequest").style.display = 'none';
});

document.getElementById("CarForm").addEventListener('click', function () {
    document.getElementById("DashboardF").style.display = 'none';
    document.getElementById("CarF").style.display = 'inline-block';
    document.getElementById("CustomerF").style.display = 'none';
    document.getElementById("DriverF").style.display = 'none';
    document.getElementById("CarRentalF").style.display = 'none';
    document.getElementById("PaymentF").style.display = 'none';
    document.getElementById("rentalRequest").style.display = 'none';
});
document.getElementById("CustomerForm").addEventListener('click', function () {
    document.getElementById("DashboardF").style.display = 'none';
    document.getElementById("CarF").style.display = 'none';
    document.getElementById("CustomerF").style.display = 'inline-block';
    document.getElementById("DriverF").style.display = 'none';
    document.getElementById("CarRentalF").style.display = 'none';
    document.getElementById("PaymentF").style.display = 'none';
    document.getElementById("rentalRequest").style.display = 'none';
});
document.getElementById("DriverForm").addEventListener('click', function () {
    document.getElementById("DashboardF").style.display = 'none';
    document.getElementById("CarF").style.display = 'none';
    document.getElementById("CustomerF").style.display = 'none';
    document.getElementById("DriverF").style.display = 'inline-block';
    document.getElementById("CarRentalF").style.display = 'none';
    document.getElementById("PaymentF").style.display = 'none';
    document.getElementById("rentalRequest").style.display = 'none';
});
document.getElementById("CarRentalForm").addEventListener('click', function () {
    document.getElementById("DashboardF").style.display = 'none';
    document.getElementById("CarF").style.display = 'none';
    document.getElementById("CustomerF").style.display = 'none';
    document.getElementById("DriverF").style.display = 'none';
    document.getElementById("CarRentalF").style.display = 'inline-block';
    document.getElementById("PaymentF").style.display = 'none';
    document.getElementById("rentalRequest").style.display = 'none';
});
document.getElementById("PaymentForm").addEventListener('click', function () {
    document.getElementById("DashboardF").style.display = 'none';
    document.getElementById("CarF").style.display = 'none';
    document.getElementById("CustomerF").style.display = 'none';
    document.getElementById("DriverF").style.display = 'none';
    document.getElementById("CarRentalF").style.display = 'none';
    document.getElementById("PaymentF").style.display = 'inline-block';
    document.getElementById("rentalRequest").style.display = 'none';
});
document.getElementById("RentalRequestForm").addEventListener('click', function () {
    document.getElementById("DashboardF").style.display = 'none';
    document.getElementById("CarF").style.display = 'none';
    document.getElementById("CustomerF").style.display = 'none';
    document.getElementById("DriverF").style.display = 'none';
    document.getElementById("CarRentalF").style.display = 'none';
    document.getElementById("PaymentF").style.display = 'none';
    document.getElementById("rentalRequest").style.display = 'inline-block';
});