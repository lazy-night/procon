# -*- coding: utf-8 -*-

class String
  # ヒアドキュメントをインデントして使えるようにする
  def ~
    margin = scan(/^ +/).map(&:size).min
    gsub(/^ {#{margin}}/, '')
  end
end
