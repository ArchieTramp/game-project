<#ftl encoding='UTF-8'>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Interface</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="wrapper">
    <div class="profile">
        <div class="profile-window">
            <h2 class="profile-title">Характеристики персонажа</h2>
            <table class="specifications">
                <tr class="specification-item">
                    <td>NICKNAME</td>
                    <td>${player.nickName}</td>
                </tr>
                <tr class="specification-item">
                    <td>HP</td>
                    <td>${player.HP}</td>
                </tr>
                <tr class="specification-item">
                    <td>MP</td>
                    <td>${player.MP}</td>
                </tr>
                <tr class="specification-item">
                    <td>Gold</td>
                    <td>${player.gold}</td>
                </tr>
                <tr class="specification-item">
                    <td>LVL</td>
                    <td>${player.level}</td>
                </tr>
                <tr class="specification-item">
                    <td>EXP</td>
                    <td>${player.experience}</td>
                </tr>
                <tr class="specification-item">
                    <td>Bandit</td>
                    <td>${player.bandit}</td>
                </tr>

            </table>
            <h3 class="skills">Навыки</h3>
            <table class="specifications">
                <tr class="specification-item">
                    <td>INTELLIGENCE</td>
                    <td>${player.intelligence}</td>
                </tr>
                <tr class="specification-item">
                    <td>STRENGTH</td>
                    <td>${player.strength}</td>
                </tr>
                <tr class="specification-item">
                    <td>CHARISMA</td>
                    <td>${player.charisma}</td>
                </tr>
                <tr class="specification-item">
                    <td>LUCK</td>
                    <td>${player.luck}</td>
                </tr>
            </table>
        </div>
    </div>
    <div class="game">
        <div class="game-window">
            <#if gameMessage??>
                <h2>${gameMessage}</h2>
            </#if>
        </div>
<#--        <div class="game-window">-->
<#--            <h2>Hello</h2>-->
<#--        </div>-->
    </div>
    <div class="actions">
        <div class="action-window">
            <h2 class="action-title">Действия</h2>
            <ul class="action-items">
                <form action="${'/lootcaravan'}" method="post">
                    <input class="action-item" type="submit" value="Ограбить караван">
                </form>
                <form action="${'/mercenary'}" method="post">
                    <input class="action-item" type="submit" value="Нанять бойца">
                </form>

                <form action="${'/saloon'}" method="post">
                    <input class="action-item" type="submit" value="Зайти в Saloon">
                </form>
                <form action="${'/exitGame'}" method="post">
                    <input class="action-item" type="submit" value="Выйти из игры">
                </form>


                <#--                <li class="action-item" data-eventMessage="aggressive"><a href="#" data-eventMessage="aggressive">Ограбить караван</a></li>-->
                <#--                    <li class="action-item" data-eventMessage="aggressive"><a href="#" data-eventMessage="aggressive">Ограбить-->
                <#--                            игрока</a></li>-->
                <#--                    <li class="action-item" data-eventMessage="aggressive"><a href="#" data-eventMessage="aggressive">Вызвать-->
                <#--                            на дуэль</a></li>-->
                <#--                    <li class="action-item" data-eventMessage="neutral"><a href="#" data-eventMessage="neutral">Нанять-->
                <#--                            бойца</a></li>-->
                <#--                    <li class="action-item" data-eventMessage="neutral"><a href="#" data-eventMessage="neutral">Зайти в-->
                <#--                            Saloon</a></li>-->
                <#--                    <li class="action-item" data-eventMessage="positive"><a href="#" data-eventMessage="positive">Отдохнуть</a>-->
                <#--                    </li>-->
                <#--                    <li class="action-item" data-eventMessage="positive"><a href="#" data-eventMessage="positive">Повысить-->
                <#--                            уровень</a></li>-->
            </ul>
        </div>
    </div>
    <div class="chat">
        <div class="chat-window">
            <h2 class="chat-title">Чат</h2>
            <div class="messages">
                <div class="message-items"></div>
                <form id="message-form" class="message-form">
                    <input type="text" class="chat-input" name="chat">
                    <button id="message-send" class="message-send">
                        <img src="images/message-button.png" width="100%" height="100%">
                    </button>
                </form>
            </div>
        </div>
    </div>
    <div class="events">
        <div class="event-window">
            <h2 class="event-title">События</h2>
            <div class="event-items"></div>
        </div>
    </div>
</div>

</body>
</html>