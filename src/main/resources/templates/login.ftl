<#ftl encoding='UTF-8'>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Авторизация</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>
<#if error??>
<div class="alert alert-danger" role="alert">Логин или пароль введены неверно</div>
    <div class=""
</#if>

<div class="autorization-block">
    <h1 class="autorization-title">Авторизация</h1>
    <form class="autorization-form">
        <fieldset class="autorization-item">
            <label for="login">Логин</label>
            <input type="text" name="login">
        </fieldset>
        <fieldset class="autorization-item">
            <label for="password">Пароль</label>
            <input type="password" name="password">
        </fieldset>
        <fieldset class="registration-item">
<#--            <label for="remember-me">-->
                <input type="checkbox" id="remember-me" name="remember-me">Запомнить меня
<#--            </label>-->
            <button type="submit" formmethod="post" formaction="/login">Войти</button>
            <button type="submit" formmethod="get" formaction="/signup">Регистрация</button>
        </fieldset>
    </form>
</div>

</body>
</html>
