<?php

namespace App\Http\Controllers\Admin;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Student;

class StudentController extends Controller
{
    public function index()
    {
        $items = Student::all();

        return view('pages.admin.student.index',[
            'items' => $items
        ]);
    }
}
