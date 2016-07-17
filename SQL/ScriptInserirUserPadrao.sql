
INSERT INTO bibliotecas ( nome )   
    SELECT 'padrao'
     WHERE NOT EXISTS (
       SELECT id
         FROM bibliotecas 
        WHERE nome like 'padrao'
        ) 

INSERT INTO usuarios ( bibliotecas_id,codUsuario,nome,endereco,cpf,role)   
    SELECT (SELECT id FROM bibliotecas WHERE nome like 'padrao'),0001,'admin','user padrao','00000000000','admin'
     WHERE NOT EXISTS (
       SELECT id as uId
         FROM usuarios 
        WHERE nome like 'admin'
        )   