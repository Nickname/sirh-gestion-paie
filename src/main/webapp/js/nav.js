$(document).ready(function(){
  $("#nav").html(`
    <div id='navigation'>
      <nav class='navbar-nav navbar-dark navbar-expand-lg bg-dark'>
        <a class="navbar-brand" href="/paie/mvc/employes/lister" style="margin-left: 25px;"><i class="fa fa-briefcase" aria-hidden="true"></i></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar" aria-controls="navbar" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbar">
          <ul class="navbar-nav">
            <li id='employes' class="nav-item">
              <a class='nav-link' href='/paie/mvc/employes/lister'>Employes</a>
            </li>
            <li id='bulletins' class="nav-item">
              <a class='nav-link' href='/paie/mvc/bulletins/lister'>Bulletins</a>
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