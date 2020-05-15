<?php

namespace App\Http\Controllers\API;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Question;
use App\Student;

class APIController extends Controller
{
    public function index()
    {
        return Question::all();
    }

    public function store(Request $request, Student $student, $nis)
    {
        $student::where("nis", $nis)->update($request->all());

        return response()->json($student, 200);
    }

    public function loginStudent(Student $student)
    {
        return $student;
    }

    public function registerStudent(Request $request)
    {
        $student = Student::create($request->all());

        return response()->json($student, 201);
    }
}
