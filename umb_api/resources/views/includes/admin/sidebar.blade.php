<!-- Sidebar -->
<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

    <!-- Sidebar - Brand -->
<a class="sidebar-brand d-flex align-items-center justify-content-center" href="{{ route('dashboard') }}">
    UMB Admin
    </a>

    <!-- Divider -->
    <hr class="sidebar-divider my-0">

    <!-- Nav Item - Dashboard -->
    <li class="nav-item {{ Route::currentRouteName() == 'dashboard' ? 'active':'' }}">
    <a class="nav-link" href="{{ route('dashboard') }}">
        <i class="fas fa-fw fa-tachometer-alt"></i>
        <span>Dashboard</span></a>
    </li>

    <li class="nav-item {{ Route::currentRouteName() == 'question.index' ? 'active':'' }}">
    <a class="nav-link" href="{{ route('question.index') }}">
        <i class="fas fa-fw fa-question"></i>
        <span>Kelola Soal</span></a>
    </li>

    <li class="nav-item {{ Route::currentRouteName() == 'student' ? 'active':'' }}">
    <a class="nav-link" href="{{ route('student') }}">
        <i class="fas fa-fw fa-file-alt"></i>
        <span>Hasil Siswa</span></a>
    </li>

    <hr class="sidebar-divider">

    <!-- Sidebar Toggler (Sidebar) -->
    <div class="text-center d-none d-md-inline">
    <button class="rounded-circle border-0" id="sidebarToggle"></button>
    </div>

</ul>
<!-- End of Sidebar -->