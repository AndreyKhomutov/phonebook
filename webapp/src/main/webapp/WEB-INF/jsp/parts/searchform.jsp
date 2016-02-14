<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="jumbotron">
    <form action="doSearch" method="post">
        <div class="container">
            <h2>Search</h2>

            <div class="col-lg-6">
                <div class="input-group">
                    <input type="text" name="search" class="form-control" id="search">
      <span class="input-group-btn">
        <input type="submit" value="Search" class="btn btn-default">
      </span>
                </div>
            </div>
        </div>
    </form>
</div>
<script>
    <%@include file="/resources/js/search.js" %>
</script>
<div id="result"></div>

