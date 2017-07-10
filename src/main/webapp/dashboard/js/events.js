$(document).ready(function() {
    $('#eventsResult').DataTable( {
        "processing": true,
        "serverSide": true,
        "ajax": "/events"
    } );
} );