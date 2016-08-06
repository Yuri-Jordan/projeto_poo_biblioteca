CREATE  or Replace VIEW itemAcervo_all AS
	SELECT  i.id, i.bibliotecas_id,a.user_id, i.custo, i.codigoitem, i.especifico,
		a.dataaluguel, a.datadevolucao, a.pago,a.devolvido,a.id as idAlugado,
		a.itemacervo_id
	FROM itemacervos as i
	LEFT JOIN alugado as a
	ON a.id = (SELECT p.id from alugado p where p.itemacervo_id = i.id ORDER BY p.id DESC LIMIT 1)
	