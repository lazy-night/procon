class Scheduling
  Job = Struct.new('Job', :start, :end)
  def initialize(n, s, t)
    @n = n
    # 終了時刻、開始時刻の順でソートしておく
    @jobs = s.map.with_index {|start, i|
      Job.new(start, t[i])
    }.sort_by!{|job| job.start}.sort_by!{|job| job.end} #逆じゃないよ
  end

  # 終了時刻の小さなものから貪欲に受注してけば良い
  def calc
    last_end = 0
    count = 0
    @jobs.each do |job|
      if job.start > last_end
        count += 1
        last_end = job.end
      end
    end
    count
  end
end
