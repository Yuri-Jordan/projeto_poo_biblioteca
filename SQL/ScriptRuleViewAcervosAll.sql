CREATE OR REPLACE RULE itemacervo_all_UPDATE AS ON UPDATE TO itemacervo_all DO INSTEAD (
       UPDATE itemacervos SET bibliotecas_id=NEW.bibliotecas_id, custo=NEW.custo,codigoitem=NEW.codigoitem,especifico=NEW.especifico WHERE id=OLD.id;
       UPDATE alugado SET dataaluguel=NEW.dataaluguel, datadevolucao=NEW.datadevolucao,pago=NEW.pago,devolvido=NEW.devolvido,user_id=NEW.user_id,itemacervo_id=NEW.itemacervo_id WHERE id=OLD.id
      );