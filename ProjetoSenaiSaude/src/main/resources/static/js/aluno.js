$(document).ready(function() {
	loadAlunos();

	$('#alunoForm').submit(function(event) {
		event.preventDefault();
		const id = $('#alunoId').val();
		if (id) {
			updateAluno(id);
		} else {
			addAluno();
		}
	});
});

function loadAlunos() {
	$.getJSON('/aluno', function(data) {
		$('#alunoTableBody').empty();
		data.forEach(aluno => {
			$('#alunoTableBody').append(
				`<tr>
					<td style="background-color: #DCF3F6;">${aluno.id}</td>
                    <td style="background-color: #DCF3F6;">${aluno.nome}</td>
                    <td style="background-color: #DCF3F6;">${aluno.email}</td>
                    <td style="background-color: #DCF3F6;">${aluno.senha}</td>
                    <td style="background-color: #DCF3F6;">
                    	<button class="btn btn-sm btn-warning botao-1" onclick="showEditAlunoForm(${aluno.id}, '${aluno.nome}', '${aluno.email}', '${aluno.senha}')">Edit</button>
                    	<button class="btn btn-sm btn btn-secondary" onclick="deleteAluno(${aluno.id})">Delete</button>
                    </td>
                 </tr>`
			);
		});
	});
}

function ShowAddAluno() {
	$('#formTitle').text('Add alunos');
	$('#alunoId').val('');
	$('#alunoNome').val('');
	$('#alunoEmail').val('');
	$('#alunoSenha').val('');
	$('#alunoFormModal').show();
	console.log("funciona")
}

function showEditAlunoForm(id, nome, email, senha) {
	$('#formTitle').text('Edit Aluno');
	$('#alunoId').val(id);
	$('#alunoNome').val(nome);
	$('#alunoEmail').val(email);
	$('#alunoSenha').val(senha);
	$('#alunoFormModal').show();
}

function closeAlunoForm() {
	$('#alunoFormModal').hide();
}

function addAluno() {
	const aluno = {
		nome: $('#alunoNome').val(),
		email: $('#alunoEmail').val(),
		senha: $('#alunoSenha').val()
	};
	$.ajax({
		url: '/aluno',
		type: 'POST',
		contentType: 'application/json',
		data: JSON.stringify(aluno),
		success: function() {
			closeAlunoForm();
			loadAlunos();
		}
	});
}

function updateAluno(id) {
	const aluno = {
		nome: $('#alunoNome').val(),
		email: $('#alunoEmail').val(),
		senha: $('#alunoSenha').val()
	};
	$.ajax({
		url: `/aluno/${id}`,
		type: 'PUT',
		contentType: 'application/json',
		data: JSON.stringify(aluno),
		success: function() {
			closeAlunoForm();
			loadAlunos();
		}
	});
}

function deleteAluno(id) {
	if (confirm('Realmente vai deletar?')) {
		$.ajax({
			url: `/aluno/${id}`,
			type: 'DELETE',
			success: function() {
				loadAlunos();
			}
		});
	}
}
