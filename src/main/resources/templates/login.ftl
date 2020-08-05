<#ftl encoding='UTF-8'>
<html>
<head>
    <link href="/css/styles.css" rel="stylesheet">
    <link href="/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<#if error??>
<div class="alert alert-danger" role="alert">Логин или пароль введены неверно</div>
    <div class=""
</#if>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Пожалуйста зарегистрируйтесь!
    </div>
    <form method="post" action="/login">
        <label for="login">Логин
            <input class="input-field" type="text" id="login" name="login">
        </label>
        <br>
        <label for="password">Пароль
            <input class="input-field" type="password" id="password" name="password">
        </label>
        <br>
        <label for="remember-me">
            <input type="checkbox" id="remember-me" name="remember-me">Запомнить меня</label>
        <input type="submit" value="Войти">
    </form>
    <form method="get" action="/signup">
        <input type="submit" value="Регистрация">
    </form>

</div>
</body>
</html>
