<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Student extends Model
{
    protected $fillable = ['nis','minat1','minat2'];

    public function user(){
        return $this->belongsTo(User::class, 'id', 'id');
    }
}
