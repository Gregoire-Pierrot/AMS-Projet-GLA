let isEditing = false;

function toggleEdit() {
    const inputs = document.querySelectorAll('#Part2 input');
    const spans = document.querySelectorAll('#account-form span');
    const editButton = document.getElementById('edit-btn');


    if (!isEditing) {
        spans.forEach((span, index) => {
            span.style.display = 'none';
            inputs[index].style.display = 'inline-block';
            inputs[index].setAttribute("value", span.textContent.trim());
        });

        editButton.textContent = "Enregistrer";
        isEditing = true;
    } else {
        editButton.setAttribute("type", "submit");
    }
}