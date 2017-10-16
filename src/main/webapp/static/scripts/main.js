console.log("test");
let birthplace = document.getElementById('birthplace');
let address = document.getElementById('address');
let language = document.getElementById('lang');
let education = document.getElementById('education');
address.style.display = "none";
birthplace.style.display = "none";
language.style.display = "none";
education.style.display = "none";
function show() {
    if (document.getElementById("employee-place").checked) birthplace.style.display = "block";
    else birthplace.style.display = "none";
    if (document.getElementById("employee-address").checked) address.style.display = "block";
    else address.style.display = "none";
    if (document.getElementById("language").checked) language.style.display = "block";
    else language.style.display = "none";
    if (document.getElementById("employee-education").checked) education.style.display = "block";
    else education.style.display = "none";

};