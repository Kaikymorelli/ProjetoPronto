$(document).ready(function() {
	loadAgendamentos();

	$('#agendamentoForm').submit(function(event) {
		event.preventDefault();
		const id = $('#agendamentoId').val();
		if (id) {
			updateAgendamento(id);
		} else {
			addAgendamento();
		}
	});
});

function loadAgendamentos() {
	$.getJSON('/agendamento', function(data) {
		$('#agendamentoTableBody').empty();
		data.forEach(agendamento => {
			$('#agendamentoTableBody').append(
				`<tr>
					<td style="background-color: #DCF3F6;">${agendamento.id}</td>
                    <td style="background-color: #DCF3F6;">${agendamento.nome}</td>
                    <td style="background-color: #DCF3F6;">${agendamento.email}</td>
                    <td style="background-color: #DCF3F6;">${agendamento.data}</td>
                    <td style="background-color: #DCF3F6;"S>${agendamento.horario}</td>
                    <td style="background-color: #DCF3F6;">
                    	<button class="btn btn-sm btn-warning botao-1" onclick="showEditAgendamentoForm(${agendamento.id}, '${agendamento.nome}', '${agendamento.email}', '${agendamento.data}', '${agendamento.horario}')">Edit</button>
                    	<button class="btn btn-sm btn btn-secondary" onclick="deleteAgendamento(${agendamento.id})">Delete</button>
                    </td>
                 </tr>`
			);
		});
	});
}

function ShowAddAgendamento() {
	$('#formTitle').text('Add agendamentos');
	$('#agendamentoId').val('');
	$('#agendamentoNome').val('');
	$('#agendamentoEmail').val('');
	$('#agendamentoData').val('');
	$('#agendamentoHorario').val('');
	$('#agendamentoFormModal').show();
	console.log("funciona")
}

function showEditAgendamentoForm(id, nome, email, senha) {
	$('#formTitle').text('Edit Agendamento');
	$('#agendamentoId').val(id);
	$('#agendamentoNome').val(nome);
	$('#agendamentoEmail').val(email);
	$('#agendamentoData').val(data);
	$('#agendamentoHorario').val(horario);
	$('#agendamentoFormModal').show();
}

function closeAgendamentoForm() {
	$('#agendamentoFormModal').hide();
}

function addAgendamento() {
	const agendamento = {
		nome: $('#agendamentoNome').val(),
		email: $('#agendamentoEmail').val(),
		data: $('#agendamentoData').val(),
		horario: $('#agendamentoHorario').val()
	};
	$.ajax({
		url: '/agendamento',
		type: 'POST',
		contentType: 'application/json',
		data: JSON.stringify(agendamento),
		success: function() {
			closeAgendamentoForm();
			loadAgendamentos();
		}
	});
}

function updateAgendamento(id) {
	const agendamento = {
		nome: $('#agendamentoNome').val(),
		email: $('#agendamentoEmail').val(),
		data: $('#agendamentoData').val(),
		horario: $('#agendamentoHorario').val()
	};
	$.ajax({
		url: `/agendamento/${id}`,
		type: 'PUT',
		contentType: 'application/json',
		data: JSON.stringify(agendamento),
		success: function() {
			closeAgendamentoForm();
			loadAgendamentos();
		}
	});
}

function deleteAgendamento(id) {
	if (confirm('Realmente vai deletar?')) {
		$.ajax({
			url: `/agendamento/${id}`,
			type: 'DELETE',
			success: function() {
				loadAgendamentos();
			}
		});
	}
}
