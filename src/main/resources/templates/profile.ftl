<#ftl encoding='UTF-8'>
<html>
<head>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
    <link href="/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="form-style-2-heading">${user.firstName}</div>
<div class="form-style-2-heading">${user.lastName}</div>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Создайте игрового персонажа.
    </div>
    <form method="post" action="/">
        <br>
        <label for="nick-name">NickName
            <input class="input-field" id="nick-name" name="nickName">
            <#if message??>
                <div class="alert alert-danger" role="alert">${message}</div>
            </#if>
        </label>
        <br>
        <label for="remember-me">
            <input type="checkbox" id="remember-me" name="remember-me">Запомнить меня</label>
        <input type="submit" value="Создать">
        <br>
    </form>
</div>

<a href="/users">Для администратора</a>
<p></p>
<a href="/logout">Выход</a>
</body>
</html>