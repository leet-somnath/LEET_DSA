var toogle = document.querySelector('#toogle');
toogle.addEventListener('mouseover', function(){
    if (document.body.style.backgroundColor == "white") {
        document.body.style.backgroundColor = "black";
    } else {
        document.body.style.backgroundColor = "white";
    }
});


var liked = document.querySelector('#count'); // Correct selector for count element
var incre = document.querySelector('#incrementor');
var decre = document.querySelector('#decrementor');
var c = 0;

incre.addEventListener('click', function() {
    c++;
    liked.innerText = c; // Update the span with the new count
    
});

decre.addEventListener('click', function() {
    if (c > 0) {
        c--;
    }
    liked.innerText = c; // Update the span with the new count
});
