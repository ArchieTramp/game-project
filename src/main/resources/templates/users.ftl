<html>
<head>
    <title>Title</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
    <link href="/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Already in System!
    </div>
    <table>
        <tr>
            <th>Login</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Action</th>
            <th>State</th>
        </tr>
        <#list usersFromServer as user>
            <tr>
                <form method="post" action="/users">
                    <br>
                    <td>${user.id}</td>
                    <td>${user.login}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.state}</td>
                    <td>
                        <a href="${'/users/' + user.id}">Edit</a>
                    </td>
                    <br>
                </form>
            </tr>
        </#list>
    </table>
</div>
<a href="/">Вернуться на главную страницу</a>
</body>
</html>
