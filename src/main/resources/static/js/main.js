document.addEventListener('DOMContentLoaded', function () {
    initializeSideNav()
})

function initializeSideNav() {
    var sidenavElement = document.querySelectorAll('.sidenav')
    M.Sidenav.init(sidenavElement, {
        draggable: true
    })
}
