
function toggleQRCode() {
    var qrCodeDiv = document.getElementById('qrCode');
    if (qrCodeDiv.style.display === 'none') {
        qrCodeDiv.style.display = 'block';
    } else {
        qrCodeDiv.style.display = 'none';
    }
}