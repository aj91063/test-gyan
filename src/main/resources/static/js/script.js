


const sideMenu=document.querySelector("aside");
const menueBtn=document.querySelector("#menu-btn");
const closeBtn=document.querySelector("#close-btn");
const themeToggler=document.querySelector(".theme-toggler");
localStorage.setItem('theme','dark-theme-variables');


menueBtn.addEventListener('click', ()=>{
    sideMenu.style.display='block';
});

closeBtn.addEventListener('click', ()=>{
    sideMenu.style.display='none';
});

themeToggler.addEventListener('click', ()=>{
    document.body.classList.toggle('dark-theme-variables');
    localStorage.setItem('theme','dark-theme-variables');
    themeToggler.querySelector('span:nth-child(1)').classList.toggle('active');
    themeToggler.querySelector('span:nth-child(2)').classList.toggle('active');
});

 function capitalizeInput() {
            let input = document.getElementById("capitalizedInput");
            let words = input.value.toLowerCase().split(' ');
            for (let i = 0; i < words.length; i++) {
                words[i] = words[i].charAt(0).toUpperCase() + words[i].slice(1);
            }
            input.value = words.join(' ');
 }


//const header = document.getElementById("sidebarId");
//var btns = header.getElementsByClassName("btn");
//// console.log(btns)
//for (var i = 0; i < btns.length; i++) {
//  btns[i].addEventListener("click", function() {
//  var current = document.getElementsByClassName("active");
//  current[0].className = current[0].className.replace(" active", "");
//  this.className += " active";
//  });
//}


const now = new Date();
const currentDate = now.toLocaleDateString('en-US', {
    year: 'numeric',
    month: '2-digit',
    day: '2-digit',
  });

  const dateId=document.getElementById('dateId')
  dateId.innerHTML+=currentDate;