/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 //fonction envoyer
            function envoyerAjax(son) {

                //envoyer en ajax
                $.ajax(
                        {   
                            type: "POST",
                            url: "../vue/index.xhtml",
                            data: "arg1=" + son,
                            timeout: 10000,
                            error: function () {
                                alert('Erreur lors de l\'envoi');
                            }//,
                           /* //image de chargement
                            beforeSend: function () {
                                $("#ajaxloader").css("display", "block");
                            },
                            //cache l'image à la fin du chargement
                            success: function (msg) {
                                $("#ajaxloader").css("display", "none");
                    */        
                    }
                        });
            }

 /*
 //au chargement de la page
            $(function () {

                //servo-slider horizontal
                $("#soundBar").slider({
                    orientation: "horizontal", //orientation du slider
                    min: 1, //slide bar valeur min
                    max: 100, //slide bar valeur max
                    step: 1, // pas d'incrémentation
                    value: 50, // position d'initialisation
                    slide: function (event, ui) {
                         alert('hello');
                        $("#valueSound").val(ui.value);
                    }
                });}
                
   */             
            
            function maFonction(){
            alert('coucou');
            
            }