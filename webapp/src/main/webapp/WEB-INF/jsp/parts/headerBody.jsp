<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="\">Main</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <% if (session.getAttribute("user") == null && session.getAttribute("profileType") == null) {
            %>
            <form action="Login" method="post" class="navbar-form navbar-right">
                <div class="form-group">
                    <input type="text" name="user" placeholder="Login" class="form-control">
                </div>
                <div class="form-group">
                    <input type="password" name="pwd" placeholder="Password" class="form-control">
                </div>
                <button type="submit" value="Login" class="btn btn-success">Enter</button>
                <label>
                    <input type="checkbox" name="remember_me" id="remember_me">
                    Remember me on this computer
                </label>
            </form>
            <%
            } else {
                String user = (String) session.getAttribute("user");
            %>
            <form action="Logout" method="post" class="navbar-form navbar-right">
                <div class="form-group">
                    <h4><p class="text-success"> Welcome <%=user%> !</h4>
                    </p>
                </div>
                <div class="form-group">
                    <input type="submit" value="Logout" class="btn btn-success">
                </div>
            </form>
            <% } %>
        </div>
    </div>
</nav>
