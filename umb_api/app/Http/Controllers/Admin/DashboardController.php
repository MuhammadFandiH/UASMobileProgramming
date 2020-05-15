<?php

namespace App\Http\Controllers\Admin;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Student;

class DashboardController extends Controller
{
    public function index(Request $request)
    {
        return view('pages.admin.dashboard',[
            'siswa' => Student::count(),
            'sudah' => Student::whereNotNull('minat1')->count(),
            'pending' => Student::whereNull('minat1')->count()
        ]);
    }
}
