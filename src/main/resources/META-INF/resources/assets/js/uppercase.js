document.addEventListener('DOMContentLoaded', function () {
    document.querySelectorAll('.uppercase-input').forEach(el => {
        el.addEventListener('input', function () {
            this.value = this.value.toUpperCase();
        });
    });
});
