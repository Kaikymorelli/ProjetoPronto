$(document).ready(function() {
	loadPsicologas();

	$('#psicologaForm').submit(function(event) {
		event.preventDefault();
		const id = $('#psicologaId').val();
		if (id) {
			updatePsicologa(id);
		} else {
			addPsicologa();
		}
	});
});

function loadPsicologas() {
	$.getJSON('/psicologa', function(data) {
		$('#psicologaTableBody').empty();
		data.forEach(psicologa => {
			$('#psicologaTableBody').append(
				`<tr>
					<td style="background-color: #DCF3F6;">${psicologa.id}</td>
                    <td style="background-color: #DCF3F6;">${psicologa.nome}</td>
                    <td style="background-color: #DCF3F6;">${psicologa.email}</td>
                    <td style="background-color: #DCF3F6;">${psicologa.senha}</td>
                    <td style="background-color: #DCF3F6;">${psicologa.cfp}</td>
                    <td style="background-color: #DCF3F6;">
                    	<button class="btn btn-sm btn-warning botao-1" onclick="showEditPsicologaForm(${psicologa.id}, '${psicologa.nome}', '${psicologa.email}', '${psicologa.senha}', '${psicologa.cfp}')">Edit</button>
                    	<button class="btn btn-sm btn btn-secondary" onclick="deletePsicologa(${psicologa.id})">Delete</button>
                    </td>
                 </tr>`
			);
		});
	});
}

function ShowAddPsicologa() {
	$('#formTitle').text('Add psicologas');
	$('#psicologaId').val('');
	$('#psicologaNome').val('');
	$('#psicologaEmail').val('');
	$('#psicologaSenha').val('');
	$('#psicologaCfp').val('');
	$('#psicologaFormModal').show();
	console.log("funciona")
}

function showEditPsicologaForm(id, nome, email, senha, cfp) {
	$('#formTitle').text('Edit Psicologa');
	$('#psicologaId').val(id);
	$('#psicologaNome').val(nome);
	$('#psicologaEmail').val(email);
	$('#psicologaSenha').val(senha);
	$('#psicologaCfp').val(cfp);
	$('#psicologaFormModal').show();
}

function closePsicologaForm() {
	$('#psicologaFormModal').hide();
}

function addPsicologa() {
	const psicologa = {
		nome: $('#psicologaNome').val(),
		email: $('#psicologaEmail').val(),
		senha: $('#psicologaSenha').val(),
		cfp: $('#psicologaCfp').val()
		
		
	};
	
	$.ajax({
		url: '/psicologa',
		type: 'POST',
		contentType: 'application/json',
		data: JSON.stringify(psicologa),
		success: function() {
			closePsicologaForm();
			loadPsicologas();
			console.log(psicologa);
		}
	});
}

function updatePsicologa(id) {
	const psicologa = {
		nome: $('#psicologaNome').val(),
		email: $('#psicologaEmail').val(),
		senha: $('#psicologaSenha').val(),
		cfp: $('#psicologaCfp').val()
	};
	$.ajax({
		url: `/psicologa/${id}`,
		type: 'PUT',
		contentType: 'application/json',
		data: JSON.stringify(psicologa),
		success: function() {
			closePsicologaForm();
			loadPsicologas();
		}
	});
}

function deletePsicologa(id) {
	if (confirm('Realmente vai deletar?')) {
		$.ajax({
			url: `/psicologa/${id}`,
			type: 'DELETE',
			success: function() {
				loadPsicologas();
			}
		});
	}
}
