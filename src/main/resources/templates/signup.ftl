<#ftl encoding='UTF-8'>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Регистрация</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="registration-block">
    <h1 class="registration-title">Зарегистрируйтесь</h1>
    <form class="registration-form">
        <fieldset class="registration-item">
            <label for="login">Логин
                <input type="text" name="login">
                <#if message??>
                    <div class="alert alert-danger" role="alert">${message}</div>
                </#if>
                <#if messageLogin??>
                    <div class="alert alert-danger" role="alert">${messageLogin}</div>
                </#if>
            </label>
        </fieldset>
        <fieldset class="registration-item">
            <label for="password">Пароль
                <input type="password" name="password">
                <#if message??>
                    <div class="alert alert-danger" role="alert">${message}</div>
                </#if>
            </label>
        </fieldset>
        <fieldset class="registration-item">
            <label for="first-name">Имя
                <input type="text" id="first-name" name="firstName">
                <#if message??>
                    <div class="alert alert-danger" role="alert">${message}</div>
                </#if>
                <#if messageFirstName??>
                    <div class="alert alert-danger" role="alert">${messageFirstName}</div>
                </#if>
            </label>
        </fieldset>
        <fieldset class="registration-item">
            <label for="last-name">Фамилия
                <input type="text" id="last-name" name="lastName">
                <#if message??>
                    <div class="alert alert-danger" role="alert">${message}</div>
                </#if>
            </label>
        </fieldset>
        <fieldset class="registration-item">
            <input type="checkbox" id="remember-me" name="remember-me">Запомнить меня
            <button type="submit" formmethod="post" formaction="/signup">Зарегистрироваться</button>
            <button type="submit" formmethod="get" formaction="/login">Авторизоваться</button>
        </fieldset>
    </form>
</div>

</body>
</html>