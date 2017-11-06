$(document).ready(function(){
  $("#bandeau").html(`
    <div id='navigation'>
      <nav class='navbar-nav navbar-dark navbar-expand-lg bg-dark'>
        <a class="navbar-brand" href="#" style="margin-left: 25px;">LOG</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar" aria-controls="navbar" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbar">
          <ul class="navbar-nav">
            <li id='collaborateurs' class="nav-item">
              <a class='nav-link' href='<c:url value='mvc/employes/lister'/>'>Employes</a>
            </li>
            <li id='statistiques' class="nav-item">
              <a class='nav-link' href='<c:url value='mvc/bulletins/lister'/>'>Bulletins</a>
            </li>
          </ul>
        </div>
      </div>`
  );

  $("#navbar>ul>li").each(function(i, nav){
    if ($(nav).attr("id") == $("body").attr("id")) {
      $(nav).addClass("active");
    }
  })

})
