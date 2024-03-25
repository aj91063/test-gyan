tinymce.init({
    selector: 'textarea#default',
    width: "70vw",
    height: 300,
    plugins:[
        'advlist', 'autolink', 'link', 'image', 'lists', 'charmap', 'preview', 'anchor', 'pagebreak',
        'searchreplace', 'wordcount', 'visualblocks', 'code', 'fullscreen', 'insertdatetime', 'media', 
        'table', 'emoticons', 'template', 'codesample'
    ],
    toolbar: 'undo redo | styles | bold italic underline | alignleft aligncenter alignright alignjustify |' + 
    'bullist numlist outdent indent | link image | print preview media fullscreen | ' +
    'forecolor backcolor emoticons',
    menu: {
        favs: {title: 'Menu', items: 'code visualaid | searchreplace | emoticons'}
    },
    menubar: 'favs file edit view insert format tools table',
    content_style: 'body{font-family:Helvetica,Arial,sans-serif; font-size:16px}'
});


var inputFields = document.getElementsByClassName("inputField");
var selectElement = document.getElementById("selectElement");

function updateSelect() {
  
  selectElement.innerHTML = "<option selected disabled>---Select Answer---</option>";
  
  for (var i = 0; i < inputFields.length; i++) {
    var inputValue = inputFields[i].value;

    if(inputValue != '' && inputValue !=null){
     
      var option = document.createElement("option");
      option.text = inputValue;
      option.value=inputValue;
      selectElement.appendChild(option);
    }
   
  }
}

for (var i = 0; i < inputFields.length; i++) {
  // Add keyup event listener to each input field
  inputFields[i].addEventListener("keyup", function(event) {
    if (event.key === "Enter") {
      updateSelect();
    }
  });

  // Add blur event listener to each input field
  inputFields[i].addEventListener("blur", function() {
    updateSelect();
  });

  // Add click event listener to each input field
  inputFields[i].addEventListener("click", function() {
    updateSelect();
  });

  // Add mousedown event listener to each input field
  inputFields[i].addEventListener("mousedown", function() {
    updateSelect();
  });
}




