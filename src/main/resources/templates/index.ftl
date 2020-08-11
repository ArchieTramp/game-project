<#ftl encoding='UTF-8'>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Дикий запад</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="wrapper">
    <div class="profile">
        <div class="profile-window">
            <h2 class="profile-title">Характеристики персонажа</h2>
            <table class="specifications">
                <tr class="specification-item">
                    <td>Никнейм</td>
                    <td>${player.nickName}</td>
                </tr>
                <tr class="specification-item">
                    <td>Здоровье</td>
                    <td>${player.HP}</td>
                </tr>
                <tr class="specification-item">
                    <td>Выносливость</td>
                    <td>${player.MP}</td>
                </tr>
                <tr class="specification-item">
                    <td>Золото</td>
                    <td>${player.gold}</td>
                </tr>
                <tr class="specification-item">
                    <td>Уровень</td>
                    <td>${player.level}</td>
                </tr>
                <tr class="specification-item">
                    <td>Опыт</td>
                    <td>${player.experience}</td>
                </tr>
                <tr class="specification-item">
                    <td>Банда</td>
                    <td>${player.bandit}</td>
                </tr>

            </table>
            <h3 class="skills">Навыки (${player.point})</h3>
            <table class="specifications">
                <tr class="specification-item">
                    <td>Интеллект</td>
                    <td>${player.intelligence}</td>
                </tr>
                <tr class="specification-item">
                    <td>Сила</td>
                    <td>${player.strength}</td>
                </tr>
                <tr class="specification-item">
                    <td>Харизма</td>
                    <td>${player.charisma}</td>
                </tr>
                <tr class="specification-item">
                    <td>Удача</td>
                    <td>${player.luck}</td>
                </tr>
            </table>
            <h3 class="skills">При повышении уровня</h3>
            <form action="${'/lvlcharisma'}" method="post">
                <input class="action-item" type="submit" value="+ к харизме">
            </form>
            <form action="${'/lvlintelligence'}" method="post">
                <input class="action-item" type="submit" value="+ к уму">
            </form>
            <form action="${'/lvlluck'}" method="post">
                <input class="action-item" type="submit" value="+ к везению">
            </form>
            <form action="${'/lvlstrength'}" method="post">
                <input class="action-item" type="submit" value="+ к силе">
            </form>
        </div>
    </div>
    <div class="game">
        <div class="game-window">
            <#if gameMessage??>
                <h2>${gameMessage}</h2>
            </#if>
        </div>
    </div>
    <div class="actions">
        <div class="action-window">
            <h2 class="action-title">Действия</h2>
            <ul class="action-items">
                <form action="${'/lootcaravan'}" method="post">
                    <input class="action-item" type="submit" value="Ограбить банкирский караван">
                </form>
                <form action="${'/mercenary'}" method="post">
                    <input class="action-item" type="submit" value="Нанять бойца в банду">
                </form>
                <form action="${'/saloon'}" method="post">
                    <input class="action-item" type="submit" value="Выпить в салуне Дикий Кольт">
                </form>
                <form action="${'/lootplayers'}" method="post">
                    <input class="action-item" type="submit" value="Ограбить другого ковбоя">
                </form>
                <form action="${'/start/players'}" method="post">
                    <input class="action-item" type="submit" value="Устроить дуэль на площади">
                </form>
                <form action="${'/rest'}" method="post">
                    <input class="action-item" type="submit" value="Передохнуть в корчме У Луи">
                </form>
                <form action="${'/levupbygold'}" method="post">
                    <input class="action-item" type="submit" value="Посетить наставника Джо">
                </form>
<#--                <form action="${'/levupbyexp'}" method="post">-->
<#--                    <input class="action-item" type="submit" value="Повысить навыки">-->
<#--                </form>-->
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
            <div class="messages">
                <div class="message-items"></div>
                <form id="message-form" class="message-form">
                    <input type="text" class="chat-input" name="chat">
                    <button id="message-send" class="message-send">
                        <img src="images/message-button.png" width="30%" height="30%">
                    </button>
                </form>
            </div>
        </div>
    </div>
    <#--<div class="events">
        <div class="event-window">
            <h2 class="event-title">События</h2>
            <div class="event-items"></div>
        </div>
    </div>-->
</div>

</body>
</html>